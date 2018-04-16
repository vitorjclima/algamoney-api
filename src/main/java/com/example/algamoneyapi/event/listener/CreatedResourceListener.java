package com.example.algamoneyapi.event.listener;

import java.net.URI;

import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationListener;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.algamoneyapi.event.CreatedResourceEvent;

/**
 * @author vitor
 *
 * created on 2018-04-09
 */
public class CreatedResourceListener implements ApplicationListener<CreatedResourceEvent>{

    @Override
    public void onApplicationEvent(CreatedResourceEvent eventResource) {
        HttpServletResponse response = eventResource.getResponse();
        Long codigo = eventResource.getCodigo();

        addHeaderLocation(response, codigo);
    }

    private void addHeaderLocation(HttpServletResponse response, Long codigo) {
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().
                path("/{codigo}").buildAndExpand(codigo).toUri();
        response.setHeader("Location", uri.toASCIIString());
    }

}
