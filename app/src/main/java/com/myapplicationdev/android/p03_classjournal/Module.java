package com.myapplicationdev.android.p03_classjournal;

public class Module {

    private String moduleName;
    private String moduleCode;

    public Module(String moduleCode, String moduleName){

        this.moduleCode = moduleCode;
        this.moduleName = moduleName;
    }

    public String getModuleName() {
        return moduleName;
    }

    public String getModuleCode() {
        return moduleCode;
    }
}
