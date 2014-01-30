# sudo -u postgres bash
# psql -U postgres
> CREATE USER phonecatalog WITH PASSWORD 'phonecatalog';
> ALTER USER phonecatalog WITH CREATEDB CREATEROLE CREATEUSER;
> \q
# exit
# sudo useradd -m -p phonecatalog phonecatalog
# sudo -u phonecatalog bash
# psql -U phonecatalog -d postgres
> CREATE DATABASE phonecatalogdb WITH OWNER phonecatalog;
> \q
# psql -U phonecatalog -d phonecatalog
> GRANT ALL PRIVILEGES ON DATABASE spitterdb to dbunit;
