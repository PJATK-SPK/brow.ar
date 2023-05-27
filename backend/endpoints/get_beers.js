import Database from '../data/database.js';

class GetBeers {

    execute(req, res) {
        const db = new Database();
        const beers = db.getBeers();
        res.send(beers);
    }

}

export default GetBeers;