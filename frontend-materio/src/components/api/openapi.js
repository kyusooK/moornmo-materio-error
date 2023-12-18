import companyYaml from "./company-openapi.yaml";
import productYaml from "./product-openapi.yaml";
import salesOrderYaml from "./salesOrder-openapi.yaml";
import inventoryYaml from "./inventory-openapi.yaml";
import YAML from "json2yaml";

let apiSpec = "";

let companySpec = YAML.stringify(companyYaml);
apiSpec += companySpec;

let productSpec = YAML.stringify(productYaml);
apiSpec += productSpec;

let salesOrderSpec = YAML.stringify(salesOrderYaml);
apiSpec += salesOrderSpec;

let inventorySpec = YAML.stringify(inventoryYaml);
apiSpec += inventorySpec;


export default apiSpec;