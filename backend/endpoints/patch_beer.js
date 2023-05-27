import Database from '../data/database.js';

class PatchBeer {

    execute(req, res) {
        const beerId = req.params.id;
        const db = new Database();
        const pool = db.createPool();

        const beerSql = `
            update core.beers
            set name = $1, manufacturer_id = $2, description = $3, image_url = $4
            where id = $5`;

        const beerParams = [
            req.body.name,
            req.body.manufacturerId,
            req.body.description,
            req.body.imageUrl,
            beerId
        ];

        db.query(beerSql, pool, beerParams).then(() => {
            res.status(204).json();
        });
    }

}

export default PatchBeer;