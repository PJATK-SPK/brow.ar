import Database from '../data/database.js';

class GetBeers {

    execute(req, res) {
        const db = new Database();

        const sql = `
            select b.id, b.name, b.image_url, b.is_mock
            from core.beers b`;

        db.query(sql).then((result) => res.status(200).json(result));
    }

}

export default GetBeers;