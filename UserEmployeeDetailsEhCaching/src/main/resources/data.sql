/**
DELIMITER //
drop procedure if exists  customers_order //
CREATE PROCEDURE customers_order()
BEGIN
select customers.CustomerID,customers.CustomerName,customers.City,orders.orderdate FROM customers
LEFT JOIN orders ON customers.CustomerId = orders.CustomerId ORDER BY Customers.CustomerId;
END //
DELIMITER ;
call customers_order();




**/