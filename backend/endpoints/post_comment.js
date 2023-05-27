import Database from '../data/database.js';

class PostComment {

    execute(req, res) {
        const beerId = req.params.beerId;
        const db = new Database();
        const pool = db.createPool();

        const commentSql = `
            insert into core.comments (content, beer_id, is_mock)
            values ($1, $2, FALSE)
            returning id`

        const commentParams = [
            req.body.content,
            beerId
        ];

        db.query(commentSql, pool, commentParams).then(ids => {
            const newCommentId = ids[0].id;
            res.status(201).json({ id: newCommentId });
        });
    }

}

export default PostComment;