const APP_PORT = process.env.PORT || 5001;
const DB_USER = process.env.DB_USER || 'postgres';
const DB_HOST = process.env.DB_HOST || 'localhost';
const DB_NAME = process.env.DB_NAME || 'browar';
const DB_PASSWORD = process.env.DB_PASSWORD || 'my_password';
const DB_PORT = 5432;

export { APP_PORT, DB_USER, DB_HOST, DB_NAME, DB_PASSWORD, DB_PORT }