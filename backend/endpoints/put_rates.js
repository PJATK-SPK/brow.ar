import Database from '../data/database.js';

class PutRates {

    execute(req, res) {
        const beerId = req.params.beerId;
        const db = new Database();
        const pool = db.createPool();

        const rateSql = `
            select id from core.rates
            where beer_id = $1 and is_mock = FALSE`;

        db.query(rateSql, pool, [beerId]).then((rates) => {
            if (rates.length === 0) {
                const insertRateSql = `
                    insert into core.rates (beer_id, taste_rating, color_rating, aroma_rating, is_mock)
                    values ($1, $2, $3, $4, FALSE)
                    returning id`;

                const insertRateParams = [
                    beerId,
                    req.body.tasteRating,
                    req.body.colorRating,
                    req.body.aromaRating
                ];

                db.query(insertRateSql, pool, insertRateParams).then(ids => {
                    if (!ids || ids[0]?.id === undefined) {
                        res.status(500).json({ error: 'Error while inserting new rate' });
                    } else {
                        const newRateId = ids[0].id;
                        res.status(204).json({ id: newRateId });
                    }
                });
            } else {
                const updateRateSql = `
                    update core.rates
                    set taste_rating = $1, color_rating = $2, aroma_rating = $3
                    where id = $4`;

                const updateRateParams = [
                    req.body.tasteRating,
                    req.body.colorRating,
                    req.body.aromaRating,
                    rates[0].id
                ];

                db.query(updateRateSql, pool, updateRateParams).then(() => {
                    res.status(204).json();
                });
            }
        });
    }

}

export default PutRates;