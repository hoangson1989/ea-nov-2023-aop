-- Insert some dummy users
INSERT INTO user (name) VALUES ('Alice');
INSERT INTO user (name) VALUES ('Bob');
INSERT INTO user (name) VALUES ('Charlie');

-- Insert some dummy products
INSERT INTO product (name, price) VALUES ('Laptop', 999.99);
INSERT INTO product (name, price) VALUES ('Phone', 699.99);
INSERT INTO product (name, price) VALUES ('Tablet', 399.99);

-- Insert some dummy reviews
INSERT INTO review (comment, user_id, product_id) VALUES ('Great laptop!', 1, 1); -- Alice reviewed the Laptop
INSERT INTO review (comment, user_id, product_id) VALUES ('Good phone overall.', 2, 2); -- Bob reviewed the Phone
INSERT INTO review (comment, user_id, product_id) VALUES ('Nice tablet for the price.', 3, 3); -- Charlie reviewed the Tablet
INSERT INTO review (comment, user_id, product_id) VALUES ('Could be better.', 1, 2); -- Alice reviewed the Phone
