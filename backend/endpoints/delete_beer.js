import Database from '../data/database.js';

class DeleteBeer {

    execute(req, res) {
        const beerId = req.params.id;
        const db = new Database();
        const pool = db.createPool();

        const sql1 = `
            delete from core.rates
            where beer_id = $1;`;

        const sql2 = `
            delete from core.comments
            where beer_id = $1;`;

        const sql3 = `
            delete from core.beers
            where id = $1`;

        db.query(sql1, pool, [beerId]).then(() => {
            db.query(sql2, pool, [beerId]).then(() => {
                db.query(sql3, pool, [beerId]).then(() => {
                    res.status(204).json();
                });
            });
        });
    }

}

export default DeleteBeer;