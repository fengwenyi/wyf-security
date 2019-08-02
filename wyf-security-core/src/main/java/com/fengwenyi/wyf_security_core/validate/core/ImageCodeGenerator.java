package com.fengwenyi.wyf_security_core.validate.core;

import com.fengwenyi.wyf_security_core.properties.SecurityProperties;
import lombok.Setter;
import net.iutil.javalib.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.context.request.ServletWebRequest;

import javax.imageio.ImageIO;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Random;

/**
 * @author Erwin Feng
 * @since 2019-08-02 15:07
 */
@Setter
public class ImageCodeGenerator implements ValidateCodeGenerator {

    private SecurityProperties securityProperties;

    @Override
    public ImageCode generate(ServletRequest request) {
        return createImageCode((HttpServletRequest) request);
    }

    private ImageCode createImageCode(HttpServletRequest request) {
        int width = ServletRequestUtils.getIntParameter(request, "width",
                securityProperties.getCode().getImage().getWidth());
        int height = ServletRequestUtils.getIntParameter(request, "height",
                securityProperties.getCode().getImage().getHeight());
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

        Graphics g = image.getGraphics();

        Random random = new Random();

        g.setColor(getRandColor(200, 250));
        g.fillRect(0, 0, width, height);
        g.setFont(new Font("Times New Roman", Font.ITALIC, 30)); // 20
        g.setColor(getRandColor(160, 200));
        for (int i = 0; i < 155; i++) {
            int x = random.nextInt(width);
            int y = random.nextInt(height);
            int xl = random.nextInt(12); // 12
            int yl = random.nextInt(12); // 12
            g.drawLine(x, y, x + xl, y + yl);
        }

        StringBuilder sRand = new StringBuilder();
        for (int i = 0; i < securityProperties.getCode().getImage().getLength(); i++) {
//            String rand = String.valueOf(random.nextInt(10));
            String rand = StringUtils.getRandomString(1);
            sRand.append(rand);
            g.setColor(new Color(20 + random.nextInt(110), 20 + random.nextInt(110), 20 + random.nextInt(110)));
            g.drawString(rand, 20 * i + 10, height - 10); // 16
        }

        g.dispose();

        return new ImageCode(image, sRand.toString(), securityProperties.getCode().getImage().getExpireIn());
    }

    /**
     * 生成随机背景条纹
     *
     * @param fc
     * @param bc
     * @return
     */
    private Color getRandColor(int fc, int bc) {
        Random random = new Random();
        if (fc > 255) {
            fc = 255;
        }
        if (bc > 255) {
            bc = 255;
        }
        int r = fc + random.nextInt(bc - fc);
        int g = fc + random.nextInt(bc - fc);
        int b = fc + random.nextInt(bc - fc);
        return new Color(r, g, b);
    }
}
