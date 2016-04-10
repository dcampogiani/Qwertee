package com.danielecampogiani.qwertee.data.network.rawresponses;

import com.danielecampogiani.qwertee.presentation.data.TShirt;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.List;

public class MapperImpl implements Mapper {

    @Override
    public TShirt[] map(Rss rssResponse) {

        List<Item> responseList = rssResponse.getChannel().getList();
        int responseSize = responseList.size();
        int halfResponseSize = responseSize / 2;
        TShirt[] result = new TShirt[responseSize];
        for (int i = 0; i < responseSize; i++) {
            Item currentItem = responseList.get(i);
            String rawDescription = currentItem.getDescription().replace("\n", "").replace("<br>", " ").replaceAll("\\s+", " ");
            int firstImgIndex = rawDescription.indexOf("<img ");
            String description = rawDescription.substring(1, firstImgIndex - 1);
            int idStartIndex = firstImgIndex + 54;
            int idEndIndex = rawDescription.indexOf(".jpg");
            String idString = rawDescription.substring(idStartIndex, idEndIndex);
            int id = Integer.parseInt(idString);
            int price;
            int currentIndex = responseList.indexOf(currentItem);
            if (currentIndex >= halfResponseSize)
                price = 12;
            else
                price = 10;
            TShirt current = new TShirt(currentItem.getTitle(), description, id, price);
            result[i] = current;
        }
        return result;
    }

    @Override
    public Page map(String html) {
        Document document = Jsoup.parse(html);
        Elements tShirtsElements = document.select("li.tee-list-item");
        int len = tShirtsElements.size();
        TShirt[] result = new TShirt[len];
        for (int i = 0; i < len; i++) {
            Element imgElement = tShirtsElements.get(i).select("img").get(0);
            String imageUrl = imgElement.attr("src");
            int beginningIdIndex = imageUrl.indexOf("product-thumbs/") + 15;
            int endIdIndex = imageUrl.indexOf("-zoom");
            int id = Integer.parseInt(imageUrl.substring(beginningIdIndex, endIdIndex));

            Element priceElement = tShirtsElements.get(i).select(".product-price").get(0);
            int price = Integer.parseInt(priceElement.attr("data-tee-price-eur"));

            Element nameElement = tShirtsElements.get(i).select("a.name").get(0);
            String name = nameElement.text();

            Element descriptionElement = tShirtsElements.get(i).select("span.author").get(0);
            String description = descriptionElement.text();

            result[i] = new TShirt(name, description, id, price);
        }
        return new Page(result);
    }
}
