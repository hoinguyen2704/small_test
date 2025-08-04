*	1	D
*	2	D
*	3	B
*	4	B
*	5	B
*	6	A
*	7	A
*	8	B
*	9	D
*	10	A
*	11	B
*	12	C
*	13	D
*	14	A
*	15	B
*	16	C
*	17	A
*	18	A
*	19	B
*	20	C

Requirement 1:
* Học viên hãy viết chương trình với yêu cầu như sau:
*  Có 3 loại loại User khác nhau:
*   Leader(Trưởng nhóm)
*   Member(Thành viên)
*   Admin(Thành viên quản trị)
* Tất cả các User đều có các thuộc tính chung là: id, FullName, Email, Password Và
mỗi User có thêm các thuộc tính như sau:
* Leader có thêm thuộc tính:
*	NumberOfProject (Số Đồ án đã tham gia với vai trò Leader)
*	Member có thêm thuộc tính:
*	ProjectId (Mã Đồ án thành viên này tham gia)
*	Skill (Kỹ năng chuyên môn: Java, C#, Mysql, Scrum...)
* Và có thêm một đối tượng Project(Đồ án) có thuộc tính sau:
* ProjectId(Mã Đồ án)
* ProjectName(Tên Đồ Án)
* Size (Số Member(thành viên) tham gia Đồ án)
* LeaderId (Mã của Leader(Trưởng nhóm))
* Employees (Danh sách các thành viên tham gia làm Đồ án)
* Questions
* Hãy viết Chương trình Quản lý Member(thành viên) của Project(Đồ án) với yêu cầu sau:
1. Khởi tạo các Member, Leader, Admin, Project ở Database.
2. Viết function để user nhập vào tên Project, sau đó in ra tất cả các Member & Leader trong
Project đó (in ra dạng table(dạng bảng))
3. Viết chức năng login(Đăng nhập), User sẽ nhập Email và Password trên giao diện login Chương
trình phải kiểm tra được các hợp lệ của các thuộc tính
 Email: đúng định dạng email. (VD: quy.nguyenquang@vti.com.vn)
 Password: nhập từ 6 tới 10 ký tự, có ít nhất 1 ký tự viết hoa
4. Viết chức năng tạo thêm User dành cho Admin theo hướng dẫn sau:
* Sau khi login xong, Admin nhập FullName, Email của Employee, sau đó hệ thống sẽ tự động
* tạo tài khoản cho employee đó với password là “12345678” Chương trình phải kiểm tra được
các hợp lệ của các thuộc tính
* Email: đúng định dạng email. (VD: quy.nguyenquang@vti.com.vn)
* Fullname: chỉ chứa chữ, không chứa bất kỳ kí tự đặc biệt nào
* Chú ý:
* Viết theo OOP và đúng coding convention
* Sử đụng đầy đủ comment
* Kết hợp mô hình 3-tiers để xây dựng program
* Tuần thủ các best practice
* Không chép bài người khác (sẽ có hình thức phạt nếu bị phát hiện)


