package customer.util;

import customer.ui.home.CategoriesEnum;

public class Utils {

    public static CategoriesEnum stringToCategory(String category) throws Exception {
        switch (category){
            case "notebook" -> {return CategoriesEnum.LAPTOPS;}
            case "phone" -> {return CategoriesEnum.PHONES;}
            case "monitor" -> {return CategoriesEnum.MONITORS;}
            default -> {throw new Exception("Category not found");}
        }
    }


}
