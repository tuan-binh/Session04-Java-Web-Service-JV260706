package org.example.session04.models.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Entity
@Table(name = "users")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "full_name")
    private String fullName;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @OneToOne
    @JoinColumn(name = "identity_id") // Đặt khóa ngoại
    private Identity identity;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "user_role",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    private Set<Role> roles;

    /*
        Quan hệ nhiều nhiều có 2 biến thế nữa
        1. Sẽ có thêm thuốc tính thêm nữa
            1. 1 khóa chỉnh và 2 khóa ngoại + thuộc tính phụ (thêm)
            2. 1 khóa chính phức hợp + thuốc tính phụ (thêm) Composite key

        Student - Enrollment - Course
        User - CartItem - Product

        fetchtype:
            LAZY: - lười ko lấy giá trị lên luôn
            EAGER: - lấy giá trị lên luôn
        Mặc định
            Đuôi quan hệ là Many -> FetchType.LAZY
            Đuôi quan hệ là One -> FetchType.EAGER

        Lưu ý: gần như sẽ để mặc định luôn riêng đối với User - Role thì nên để EAGER

        Cascade: Hiệu ứng lan chuyền
            REMOVE - Xóa User -> Xóa Role
            PERSIST - Thêm User -> Thêm Role
            MERGE - Cập nhật User -> Cập nhật Role
            ALL - Tất cả các hiệu ứng trên

        Lưu ý: cascade rất nguy hiểm, hạn chế dùng
    */

}
