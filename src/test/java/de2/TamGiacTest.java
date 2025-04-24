package de2;

import com.course.Tamgiac;
import org.testng.annotations.Test;
import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;
public class TamGiacTest {

    @Test
    public void testTamGiacVuong() {
        int a = 3, b = 4, c = 5;
        assertEquals(Tamgiac.nuaChuVi(a, b, c), 6.0f, 0.001f);
        assertEquals(Tamgiac.chuVi(a, b, c), 12.0f, 0.001f);
        assertEquals(Tamgiac.dienTich(a, b, c), 6.0f, 0.001f);
    }

    @Test
    public void testTamGiacDeu() {
        int a = 6, b = 6, c = 6;
        float p = Tamgiac.nuaChuVi(a, b, c);
        float expectedArea = (float) Math.sqrt(p * (p - a) * (p - b) * (p - c));
        assertEquals(Tamgiac.dienTich(a, b, c), expectedArea, 0.001f);
    }

    @Test
    public void testKhongPhaiTamGiac() {
        int a = 1, b = 2, c = 3;
        float area = Tamgiac.dienTich(a, b, c);
        assertTrue(Float.isNaN(area) || area == 0.0f);
    }

    @Test
    public void testBienTren() {
        int a = 9, b = 9, c = 9;
        float p = Tamgiac.nuaChuVi(a, b, c);
        float expectedArea = (float) Math.sqrt(p * (p - a) * (p - b) * (p - c));
        assertEquals(Tamgiac.dienTich(a, b, c), expectedArea, 0.001f);
    }

    @Test
    public void testBienDuoi() {
        int a = 1, b = 1, c = 1;
        float p = Tamgiac.nuaChuVi(a, b, c);
        float expectedArea = (float) Math.sqrt(p * (p - a) * (p - b) * (p - c));
        assertEquals(Tamgiac.dienTich(a, b, c), expectedArea, 0.001f);
    }
}

