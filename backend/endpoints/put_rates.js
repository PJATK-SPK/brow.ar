import Database from '../data/database.js';

class PutRates {

    execute(req, res) {
        const beerId = req.params.beerId;
        const db = new Database();
        const pool = db.createPool();

        const rateSql = `
            select id from core.rates
            where beer_id = $1 and is_mock = FALSE`;

        const apiParams = [
            req.body.tasteRating,
            req.body.colorRating,
            req.body.aromaRating
        ];

        if (apiParams.some(c => !c || c > 5 || c < 1)) {
            res.status(400).json({ error: 'Invalid rate values. Please set 1-5' });
            return;
        }

        db.query(rateSql, pool, [beerId]).then((rates) => {
            if (rates.length === 0) {
                const insertRateSql = `
                    insert into core.rates (beer_id, taste_rating, color_rating, aroma_rating, is_mock)
                    values ($1, $2, $3, $4, FALSE)
                    returning id`;

                const insertRateParams = [
                    beerId,
                    ...apiParams
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
                    set taste_rating = $2, color_rating = $3, aroma_rating = $4
                    where id = $1`;

                const updateRateParams = [
                    rates[0].id,
                    ...apiParams
                ];

                db.query(updateRateSql, pool, updateRateParams).then(() => {
                    res.status(204).json();
                });
            }
        });
    }

}

export default PutRates;