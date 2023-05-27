import Database from '../data/database.js';

class GetBeer {

    execute(req, res) {
        const beerId = req.params.id;
        const db = new Database();
        const pool = db.createPool();

        const beerSql = `
            select b.id, b.name, m."name" as manufacturer_name, b.description, b.image_url, b.is_mock
            from core.beers b
            left join core.manufacturers m on b.manufacturer_id = m.id
            where b.id = $1`;

        db.query(beerSql, pool, [beerId]).then((beers) => {
            if (beers.length === 0) { res.status(404).json('Beer was not found!'); }

            const commentsSql = `
            select c.id, c.content, c.is_mock
            from core.comments c
            where c.beer_id = $1`;

            db.query(commentsSql, pool, [beerId]).then((comments) => {

                const ratesSql = `
                select c.id, c.taste_rating, c.color_rating, c.aroma_rating, c.is_mock
                from core.rates c
                where c.beer_id = $1`;

                db.query(ratesSql, pool, [beerId]).then((rates) => {
                    res.status(200).json({
                        beer: beers[0],
                        comments: comments,
                        rates: rates
                    });
                });
            });
        });
    }

}

export default GetBeer;