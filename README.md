Cấu hình dự án
- Open JDK  22
- Apache Maven 3.9.6

Các bước chạy dự án:

 B1: Clone 2 project từ GitHub :

      https://github.com/Huyen207/product-io-spring.git
     
 
      https://github.com/Huyen207/product-managerment.git
 
 B2: Chạy các lệnh sau 
 
    cd product-io-spring/
    
    run mvn install
    
  Sau khi run ta được một tập tin JAR

 B3: Sau đó chạy lệnh sau:
 
    cd product-managerment/
  
    mvn package
  
    java -jar tên_file_tại_B2
    
    
    
- Cách 2: Sử dụng IntelliJ IDEA

B1:  Mở project product-managerment bằng intelliJ

B2: Import modul product-io-spring
 
   File->Project Structure -> Modules-> Add -> Import Module từ đậy chọn project product-io-spring 

   Check Import module from external model -> maven -> Create

B3: Run ProductmanagementApplication

 

