package MembershipORM.src.main;

import MembershipORM.src.dao.JenisMemberDao;
import MembershipORM.src.dao.MemberDao;
import MembershipORM.src.view.main.MainFrame;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class Main {
    public static void main(String[] args) throws IOException {
        // Memuat konfigurasi MyBatis dari file XML
        String resource = "mybatis-config.xml";  // Sesuaikan dengan lokasi file konfigurasi Anda
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        // Membuat DAO untuk JenisMember dan Member
        JenisMemberDao jenisMemberDao = new JenisMemberDao(sqlSessionFactory);
        MemberDao memberDao = new MemberDao(sqlSessionFactory);

        // Membuat dan menampilkan frame utama aplikasi
        MainFrame f = new MainFrame(jenisMemberDao, memberDao);
        javax.swing.SwingUtilities.invokeLater(() -> {
            f.setVisible(true);
        });
    }
}
