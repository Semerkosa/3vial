use 3vial_app_source_manager;

# The keyword 'ignore' basically ignores the whole query(e.g., insert)
# Remove 'ignore' to insert the data in an empty database
# If you have the data, make sure to put 'ignore' and no re-insert the same data(throws exception)!
# Below select 1 statement is a dummy line which is needed because for some reason spring ignores the first sql
# line after the comments and in this case it will skip select 1 and execute the insert.
select 1;
insert ignore into nordigen_supported_countries (id, country_name, country_code)
values ('1', 'Bulgaria', 'BG'),
       ('2', 'Austria', 'AT'),
       ('3', 'United Kingdom', 'GB'),
       ('4', 'Germany', 'DE'),
       ('5', 'Ireland', 'IE');

