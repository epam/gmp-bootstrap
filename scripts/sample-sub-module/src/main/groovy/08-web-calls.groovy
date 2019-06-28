import com.epam.dep.esp.common.web.Web
import org.apache.http.client.config.RequestConfig

Web web = gConfig.webUtils
web.setRequestConfig(
        RequestConfig.custom()
                .setSocketTimeout(180000)
                .setConnectTimeout(180000)
                .setConnectionRequestTimeout(180000)
                .build())

web.get("http://localhost:8080/gmp/index");