package com.epam.gmp.service;

import com.epam.dep.esp.common.web.Web;
import com.epam.gmp.ExportBinding;
import org.springframework.stereotype.Service;

import javax.annotation.PreDestroy;

@Service("WebHelperService")
@ExportBinding
public class WebHelperService extends Web {

    @PreDestroy
    @Override
    public void close() {
        super.close();
    }
}
