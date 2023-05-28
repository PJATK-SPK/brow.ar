import Database from '../data/database.js';

class GetBeers {

    execute(req, res) {
        const db = new Database();

        let sql = `
            select b.id, b.name, b.image_url, b.is_mock
            from core.beers b`;

        const search = req.query.search;

        if (search) {
            sql += ` where lower(b.name) like '%${search.toLowerCase()}%'`;
        }

        db.query(sql).then((result) => res.status(200).json(result));
    }

}

export default GetBeers;