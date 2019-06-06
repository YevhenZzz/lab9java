package ua.lviv.iot.lab9;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class StationaryController {

    @Autowired
    private ClotherRepositoriy clotherRepositoriy;

    @RequestMapping(value = "/clothes", method = RequestMethod.GET)
    public List<Clothes> getClothesprettys() {
        return (List<Clothes>) clotherRepositoriy.findAll();

}
    @RequestMapping(value = "/clothes/{id}", method = RequestMethod.GET)
    public Clothes getClothesPrettys(@PathVariable Integer id) {
        return clotherRepositoriy.findById(id).get();
    }

    @RequestMapping(value = "/clothes/{id}", method = RequestMethod.PUT)
    public Clothes replaceClothes(@RequestBody Clothes newClothes, @PathVariable Integer id) {
        return clotherRepositoriy.findById(id)
                .map(clothes -> {
                    clothes.setBrand(newClothes.getBrand());
                    clothes.setColor(newClothes.getColor());
                    clothes.setPrice(newClothes.getPrice());
                    clothes.setTypesForWearing(newClothes.getTypesForWearing());
                    return clotherRepositoriy.save(clothes);
                }).orElseGet(() -> {
                    newClothes.setId(id);
                    return clotherRepositoriy.save(newClothes);
                });
    }

    @RequestMapping(value = "/clothes", method = RequestMethod.POST)
    public Clothes postClothesprettys(@RequestBody Clothes clothes) {
        return clotherRepositoriy.save(clothes);
    }

    @RequestMapping(value = "/clothes/{id}", method = RequestMethod.DELETE)
    public Clothes deleteEquity(@PathVariable Integer id) {
        Clothes temp = getClothesPrettys(id);
        clotherRepositoriy.deleteById(id);
        return temp;
    }
}