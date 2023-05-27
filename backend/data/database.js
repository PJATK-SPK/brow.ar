import pg from "pg";
const { Pool } = pg;

class Database {

    getBeers() {
        const pool = this._getPool();
        return new Promise((resolve, _) => {
            const query = pool.query(`
            select b.id, b.name, m."name" as manufacturer_name, b.description, b.image_url
            from core.beers b
            left join core.manufacturers m on b.manufacturer_id = m.id `, (error, results) => {
                if (error) {
                    resolve([]);
                }
                resolve(results.rows);
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