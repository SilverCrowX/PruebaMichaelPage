package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Module
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2020-12-03T22:30:26.029Z")




public class Module   {
  @JsonProperty("id")
  private Long id = null;

  @JsonProperty("modulename")
  private String modulename = null;

  @JsonProperty("moduleStatus")
  private String moduleStatus = null;

  public Module id(Long id) {
    this.id = id;
    return this;
  }

  /**
   * Get id
   * @return id
  **/
  @ApiModelProperty(value = "")


  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Module modulename(String modulename) {
    this.modulename = modulename;
    return this;
  }

  /**
   * Get modulename
   * @return modulename
  **/
  @ApiModelProperty(value = "")


  public String getModulename() {
    return modulename;
  }

  public void setModulename(String modulename) {
    this.modulename = modulename;
  }

  public Module moduleStatus(String moduleStatus) {
    this.moduleStatus = moduleStatus;
    return this;
  }

  /**
   * Estado del modulo
   * @return moduleStatus
  **/
  @ApiModelProperty(value = "Estado del modulo")


  public String getModuleStatus() {
    return moduleStatus;
  }

  public void setModuleStatus(String moduleStatus) {
    this.moduleStatus = moduleStatus;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Module module = (Module) o;
    return Objects.equals(this.id, module.id) &&
        Objects.equals(this.modulename, module.modulename) &&
        Objects.equals(this.moduleStatus, module.moduleStatus);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, modulename, moduleStatus);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Module {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    modulename: ").append(toIndentedString(modulename)).append("\n");
    sb.append("    moduleStatus: ").append(toIndentedString(moduleStatus)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

