import Database from '../data/database.js';

class GetManufacturers {

    execute(req, res) {
        const db = new Database();

        const sql = `
            select m.id, m.name
            from core.manufacturers m`;

        db.query(sql).then((result) => res.status(200).json(result));
    }

}

export default GetManufacturers;