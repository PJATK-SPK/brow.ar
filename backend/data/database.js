import pg from "pg";
const { Pool } = pg;

class Database {

    getBeers() {
        const sql = `
            select b.id, b.name, m."name" as manufacturer_name, b.description, b.image_url
            from core.beers b
            left join core.manufacturers m on b.manufacturer_id = m.id `;
        return this._query(sql, []);
    }

    _query(sql, params) {
        const pool = this._getPool();
        return new Promise((resolve, _) => {
            pool.connect().then(client => {
                client.query(sql, params ?? [], (error, results) => {
                    client.release();

                    if (error) {
                        console.error(error);
                        resolve([]);
                    } else {
                        resolve(results.rows);
                    }
                });
            });

        });
    }

    _getPool() {
        return new Pool({
            user: process.env.DB_USER,
            host: process.env.DB_HOST,
            database: process.env.DB_NAME,
            password: process.env.DB_PASSWORD,
            port: 5432,
        })
    }

}

export default Database;