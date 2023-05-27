import Database from '../data/database.js';

class DeleteComment {

    execute(req, res) {
        const commentId = req.params.id;
        const db = new Database();
        const pool = db.createPool();

        const commentSql = `
            delete from core.comments
            where id = $1`;

        db.query(commentSql, pool, [commentId]).then(() => {
            res.status(204).json();
        });
    }

}

export default DeleteComment;