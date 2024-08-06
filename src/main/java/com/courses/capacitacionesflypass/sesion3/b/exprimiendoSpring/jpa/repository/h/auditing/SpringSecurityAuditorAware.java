package com.courses.capacitacionesflypass.sesion3.b.exprimiendoSpring.jpa.repository.h.auditing;

class SpringSecurityAuditorAware {

       /* implements AuditorAware<User> {

  @Override
  public Optional<User> getCurrentAuditor() {

    return Optional.ofNullable(SecurityContextHolder.getContext())
            .map(SecurityContext::getAuthentication)
            .filter(Authentication::isAuthenticated)
            .map(Authentication::getPrincipal)
            .map(User.class::cast);
  }*/
}