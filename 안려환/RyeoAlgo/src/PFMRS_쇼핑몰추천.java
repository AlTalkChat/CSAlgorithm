import java.util.*;

public class PFMRS_쇼핑몰추천 {
    private static String[] products = {"towel red long thin", "blanket red thick short", "curtain red long wide", "mattress thick", "hat red thin", "pillow red long", "muffler blue thick long"};
    private static String[] purchased = {"blanket", "curtain", "hat", "muffler"};

    // 고객이 구매한 물건들의 특성을 활용해서 고객이 구매하지 않은 물품 중 가장 취향일 것같은 상품을 추천해주는 것
    public static void main(String[] args) {
        HashMap<String, List<String>> map = new HashMap<>();

        // 상품 속성을 맵에 저장
        for (String product : products) {
            String[] attributes = product.split(" ");
            String productName = attributes[0];
            List<String> productAttrs = Arrays.asList(Arrays.copyOfRange(attributes, 1, attributes.length));
            map.put(productName, productAttrs);
        }

        String recommendedProduct = findRecommendedProduct(map, purchased);
        System.out.println("추천 상품: " + recommendedProduct);
    }

    private static String findRecommendedProduct(HashMap<String, List<String>> productAttributes, String[] purchasedItems) {
        String recommendedProduct = null;
        int maxMatchingAttributes = -1; // 속성 일치 개수를 0으로 초기화

        for (String product : productAttributes.keySet()) {
            if (!Arrays.asList(purchasedItems).contains(product)) {
                int matchingAttributes = countMatchingAttributes(productAttributes.get(product), purchasedItems);

                if (matchingAttributes > maxMatchingAttributes || (matchingAttributes == maxMatchingAttributes && product.compareTo(recommendedProduct) < 0)) {
                    maxMatchingAttributes = matchingAttributes;
                    recommendedProduct = product;
                }
            }
        }

        return recommendedProduct;
    }

    private static int countMatchingAttributes(List<String> attributes1, String[] attributes2) {
        int count = 0;
        for (String attribute : attributes1) {
            if (Arrays.asList(attributes2).contains(attribute)) {
                count++;
            }
        }
        return count;
    }
}
