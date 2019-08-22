/*
 *************************************
 * Created by IntelliJ IDEA          *
 * User: Nhat                     *
 * Email: nhatnpa2508@gmail.com      *
 * Date: 7/2/2019                     *
 * Time: 5:25 PM                     *
 *************************************
 */

package Service.admin;

import Model.Admin;

import java.util.List;

public interface IAdmin {

    public Admin getAdminById(int id);

    public Admin getAdminByUsername(String username);

    public List<Admin> getAllAdmin();

    public boolean updateAdminInfo(Admin admin);

    public boolean updateAdminPassword(Admin admin);

    public boolean deleteAdmin(Admin admin);

    public String getPasswordByUsername(String username);
}
