/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.waastad.apachecxf.service;

import javax.annotation.Resource;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author Helge Waastad <helge@waastad.org>
 */

@Produces("application/json")
@Consumes(MediaType.APPLICATION_JSON)
@Path("test")
@Stateless
public class TestService {

    @Resource
    private SessionContext context;

    @GET
    public Response get() {
        System.out.println("Principal: " + context.getCallerPrincipal().getName());
        if (context.isCallerInRole("admin")) {
            System.out.println("User is admin");
        }
        return Response.ok().entity("Hi").build();
    }
}
