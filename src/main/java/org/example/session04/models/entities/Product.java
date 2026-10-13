package org.example.session04.models.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity // Sinh ra để quản lý nhận biết được đây là 1 lớp thực thể để có thể ORM
@Table(name = "products",schema = "public") // Đặt lại tên bảng khi từ java -> sql
// (nếu như ko có cái này thì sẽ lấy tên lớp làm tên table)
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder // Cũng là để khởi tạo đối tượng nhưng dưới dạng stream (thông quá các dấu .)
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", length = 100, nullable = false)
    private String name;

    @Column(name = "price")
    private Double price;

    @Column(name = "stock")
    private Integer stock;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    /*
        Product {
            id:
            name
            price
            stock
            category: {
                id
                name
            }
        }

        // query method -> findAllByCategoryId(Long categoryId) -> List<Product>
    */

}
