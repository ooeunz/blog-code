@RestController
@RequestMapping("/test")
public class TestController {
    @GetMapping
    public Account test(Account account) {
        return account;
    }
}