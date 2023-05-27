import { DB_HOST, DB_NAME, DB_PORT, DB_PASSWORD, DB_USER } from "../config.js";
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
            user: DB_USER,
            host: DB_HOST,
            database: DB_NAME,
            password: DB_PASSWORD,
            port: DB_PORT
        })
    }

}

export default Database;