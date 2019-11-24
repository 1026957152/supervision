package org.ylgjj.loan.config;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

public class RequestWrapper extends HttpServletRequestWrapper {

    private String _body;

    public RequestWrapper(HttpServletRequest request) throws IOException {
        super(request);
        _body = "";
        BufferedReader bufferedReader = request.getReader();
        String line;
        while ((line = bufferedReader.readLine()) != null){
            _body += line;
        }
    }

    @Override
    public ServletInputStream getInputStream() throws IOException {

        CustomServletInputStream kid = new CustomServletInputStream(_body.getBytes());
        return kid;
    }

    @Override
    public BufferedReader getReader() throws IOException {
        return new BufferedReader(new InputStreamReader(this.getInputStream()));
    }
}