@GetMapping("/test")
public ModelAndView test() {
    ModelAndView mav = new ModelAndView("test/viewPage");
    modelAndView.addObject("data", "Baeldung");
    return mav;
}