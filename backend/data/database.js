import { DB_HOST, DB_NAME, DB_PORT, DB_PASSWORD, DB_USER } from "../config.js";
import pg from "pg";

const { Pool } = pg;

class Database {

    query(sql, pool, params) {
        return new Promise((resolve, _) => {
            (pool ?? this.createPool()).query(sql, params ?? [], (error, results) => {
                if (error) {
                    console.error(error);
                    resolve([]);
                } else {
                    resolve(results.rows);
                }
            });
        });
    }

    createPool() {
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