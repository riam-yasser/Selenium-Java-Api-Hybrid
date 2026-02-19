@users
Feature: JSONPlaceholder API

  @get_users
  Scenario: Get all users
    Given I send a GET request to "/users"
    Then The response status should be 200

  @post_posts
  Scenario: Create a post
    Given I send a POST request to "/users"
    Then The response status should be 201


