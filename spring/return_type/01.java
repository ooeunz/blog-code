@GetMapping("/test")
public String test(Model model) {
    model.addAttribute("data", data);
    return "/test/data";
}