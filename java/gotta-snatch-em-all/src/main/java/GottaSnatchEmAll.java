import java.util.HashSet;
import java.util.List;
import java.util.Set;

class GottaSnatchEmAll {

    static Set<String> newCollection(List<String> cards) {
        Set<String> Collection = new HashSet<String>(cards);
        return Collection;
    }

    static boolean addCard(String card, Set<String> collection) {
        if (!collection.contains(card)) {
            collection.add(card);
            return true;
        } else {
            return false;
        }
    }

    static boolean canTrade(Set<String> myCollection, Set<String> theirCollection) {
        if (myCollection.isEmpty() || theirCollection.isEmpty()) {
            return false;
        } else if (!theirCollection.containsAll(myCollection) && !myCollection.containsAll(theirCollection)) {
            return true;
        } else {
            return false;
        }
    }

    static Set<String> commonCards(List<Set<String>> collections) {

        Set<String> collection = new HashSet<String>(collections.get(0));

        for (Set<String> friendCollection : collections) {
            collection.retainAll(friendCollection);
        }
        return collection;
    }

    static Set<String> allCards(List<Set<String>> collections) {

        Set<String> collection = new HashSet<String>(collections.get(0));

        for (Set<String> friendCollection : collections) {
            collection.addAll(friendCollection);
        }
        return collection;
    }

}
