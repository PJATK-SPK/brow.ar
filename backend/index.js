// Imports
import { APP_PORT } from "./config.js";
import GetBeers from "./endpoints/get_beers.js";
import express from 'express';
import bodyParser from 'body-parser';
import cors from 'cors';

const app = express();
const port = APP_PORT

// Endpoints
app.get('/beers', (req, res) => new GetBeers().execute(req, res));

// Configuration
app.use(cors());
app.use(bodyParser.urlencoded({ extended: false }));
app.use(bodyParser.json());
app.listen(port, () => console.log(`App listening on port ${port}!`));