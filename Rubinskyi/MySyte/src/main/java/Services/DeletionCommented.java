/*public static QuizTopicBean getNeededObject(String s1, String s2){
      for (QuizTopicBean aListQuiz : listQuiz) {
          if (aListQuiz.equals(new QuizTopicBean(s1, s2))){
              return aListQuiz;
          }
      }
      return new QuizTopicBean("", "");
  }

  public static void deleteFromStorage (QuizTopicBean quizTopicBean){
      Iterator<QuizTopicBean> iterator = listQuiz.iterator();
      while (iterator.hasNext()){
          if (iterator.equals(quizTopicBean)){
              iterator.remove();
              return;
          }
          iterator.next();
      }
  }*/


/*HttpServletRequest request = (HttpServletRequest) servletRequest;
            HttpServletResponse response = (HttpServletResponse) servletResponse;

            HttpSession session = request.getSession();
            if (session != null && session.getAttribute("login") != null ){
                filterChain.doFilter(servletRequest,servletResponse);
            }
            else if(!Objects.equals(request.getContextPath(), Pages.AUTHORIZATION_PAGE.getPage())){
                    response.sendRedirect(Pages.AUTHORIZATION_PAGE.getPage());
            }*/