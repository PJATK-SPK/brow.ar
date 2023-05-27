// Imports
import { APP_PORT } from "./config.js";
import GetManufacturers from "./endpoints/get_manufacturers.js";
import GetBeers from "./endpoints/get_beers.js";
import GetBeer from "./endpoints/get_beer.js";
import PostBeer from "./endpoints/post_beer.js";
import PatchBeer from "./endpoints/patch_beer.js";
import DeleteBeer from "./endpoints/delete_beer.js";
import PostComment from "./endpoints/post_comment.js";
import DeleteComment from "./endpoints/delete_comment.js";
import PutRates from "./endpoints/put_rates.js";
import express from 'express';
import bodyParser from 'body-parser';
import cors from 'cors';

const app = express();
const port = APP_PORT

// Configuration
app.use(cors());
app.use(bodyParser.urlencoded({ extended: false }));
app.use(bodyParser.json());

// Endpoints
app.get('/manufacturers', (req, res) => new GetManufacturers().execute(req, res));
app.get('/beers', (req, res) => new GetBeers().execute(req, res));
app.get('/beers/:id', (req, res) => new GetBeer().execute(req, res));
app.post('/beers', (req, res) => new PostBeer().execute(req, res));
app.patch('/beers/:id', (req, res) => new PatchBeer().execute(req, res));
app.delete('/beers/:id', (req, res) => new DeleteBeer().execute(req, res));
app.post('/beers/:beerId/comments', (req, res) => new PostComment().execute(req, res));
app.delete('/beers/:beerId/comments/:id', (req, res) => new DeleteComment().execute(req, res));
app.put('/beers/:beerId/rates', (req, res) => new PutRates().execute(req, res));

app.listen(port, () => console.log(`App listening on port ${port}!`));