import Database from '../data/database.js';

class GetBeers {

    execute(req, res) {
        const db = new Database();
        db.getBeers().then((result) => res.status(200).json(result));
    }

}

export default GetBeers;