import Database from '../data/database.js';

class PostBeer {

    execute(req, res) {
        const db = new Database();
        const pool = db.createPool();

        const beerSql = `
            insert into core.beers (name, manufacturer_id, description, image_url, is_mock)
            values ($1, $2, $3, $4, FALSE)
            returning id`

        console.log(req);

        const beerParams = [
            req.body.name,
            req.body.manufacturerId,
            req.body.description,
            req.body.imageUrl
        ];

        db.query(beerSql, pool, beerParams).then(ids => {
            const newBeerId = ids[0].id;
            res.status(201).json({ id: newBeerId });
        });
    }

}

export default PostBeer;