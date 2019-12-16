package org.egov.bpa.workflow;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

import java.util.Collections;
import java.util.*;

import static org.egov.bpa.util.BPAConstants.*;


@Configuration
@PropertySource("classpath:workflow.properties")
public class WorkflowConfig {


    private Environment env;

    @Autowired
    public WorkflowConfig(Environment env) {
        this.env = env;
        setActionStatusMap();
        setRoleActionMap();
        setActionCurrentStatusMap();
    }


    private String CONFIG_ROLES ="egov.workflow.bpa.roles";



    private  Map<String, String> actionStatusMap;

    private  Map<String, List<String>> roleActionMap;

    private  Map<String,  List<String>> actionCurrentStatusMap;




    private  void setActionStatusMap(){

        Map<String, String> map = new HashMap<>();

        map.put(ACTION_INITIATE, STATUS_INITIATED);
        map.put(ACTION_APPLY, STATUS_APPLIED);
        map.put(ACTION_APPROVE, STATUS_APPROVED);

        actionStatusMap = Collections.unmodifiableMap(map);
    }

/*    private  void setRoleActionMap(){

        Map<String, List<String>> map = new HashMap<>();

        map.put(config.getROLE_CITIZEN(), Arrays.asList(ACTION_APPLY, ACTION_INITIATE));
        map.put(config.getROLE_EMPLOYEE(), Arrays.asList(ACTION_APPLY, ACTION_INITIATE,ACTION_APPROVE, ACTION_REJECT,ACTION_CANCEL));

        roleActionMap = Collections.unmodifiableMap(map);
    }*/


    private  void setRoleActionMap(){

        Map<String, List<String>> map = new HashMap<>();

        String[] keys = env.getProperty(CONFIG_ROLES).split(",");

        for(String key : keys){
            map.put(env.getProperty(key),Arrays.asList(env.getProperty(key.replace("role","action")).split(",")));
        }

        roleActionMap = Collections.unmodifiableMap(map);
    }



    private  void setActionCurrentStatusMap(){

        Map<String, List<String>> map = new HashMap<>();

        map.put(null, Arrays.asList(ACTION_APPLY,ACTION_INITIATE));
        map.put(STATUS_INITIATED, Arrays.asList(ACTION_APPLY));
        map.put(STATUS_APPLIED, Arrays.asList(ACTION_PAY)); // FIXME PUT THE ACTIONS IN PLACE
        map.put(STATUS_PAID, Arrays.asList(ACTION_UPDTEDOCVERIFICATION, ACTION_FORWORD));
        map.put(STATUS_DOCUMENTVERIFICATION, Arrays.asList(ACTION_FIELDINSPECTION, ACTION_FORWORD));
        map.put(STATUS_FIELDINSPECTION, Arrays.asList(ACTION_NOCUPDATION, ACTION_FORWORD));
        map.put(STATUS_NOCUPDATION, Arrays.asList(ACTION_PENDINGAPPROVAL, ACTION_FORWORD));
        map.put(STATUS_PENDINGAPPROVAL, Arrays.asList(ACTION_APPROVE, ACTION_FORWORD));
        map.put(STATUS_APPROVED, Arrays.asList(ACTION_CANCEL));

        actionCurrentStatusMap = Collections.unmodifiableMap(map);
    }

    public  Map<String, String> getActionStatusMap(){
        return actionStatusMap;
    }

    public  Map<String, List<String>> getActionCurrentStatusMap(){
        return actionCurrentStatusMap;
    }

    public  Map<String, List<String>> getRoleActionMap(){
        return roleActionMap;
    }



}
