create table movie(
  id int primary key generated always as identity,
  title varchar ( 255 ) not null,
  description text,
  year int not null,
  is_watched boolean default false
);