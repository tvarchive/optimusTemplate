Feature: Advice on how to plan and save tax

  In order to save tax
  As a registered user and a working professional
  I want to get advice on how to plan and save tax
  so that I have a ton of money to spend at the end of the year

  Background:
    Given user on home screen taps on menu
    When user on menu screen taps on login
    And user on login screen types on email value mayank.gupta804@gmail.com
    And user on login screen taps on next
    And user on login screen types on password value dcba4321
    And user on login screen taps on login
    And user on home screen taps on plan

  @new
  Scenario: generic step example
    And user on planning screen taps on saveTaxCard
    And user on saveTax screen taps on letsGetStarted
    And user on saveTax screen slides on annualCTC value 60%
    And user on saveTax screen taps on nextButton
    And user on saveTax screen taps on nextButton
    And user on saveTax screen taps on switchConveyance
    And user on saveTax screen taps on switchMedical
    And user on saveTax screen taps on nextButton
    And user on saveTax screen slides on rent value 40%
    And user on saveTax screen taps on nextButton
    And user on saveTax screen slides on hra value 10%
    And user on saveTax screen taps on nextButton
    And user on saveTax screen slides on epf value 50%
    And user on saveTax screen taps on nextButton
    And user on saveTax screen taps on nextButton
    And user on saveTax screen taps on nextButton

  @new_retirement
  Scenario: generic step example 2
    And user on planning screen taps on retirementCard
    And user on retirement screen taps on letsGetStarted
    And user on retirement screen slides on age value 50%
    And user on retirement screen taps on nextButton
    And user on retirement screen slides on familyIncome value 50%
    And user on retirement screen taps on nextButton
    And user on retirement screen taps on iHaveMore
    And user on retirement screen taps on nextButton

  @children_edu
  Scenario: generic step example 3
    And user on planning screen taps on childEducationCard
    And user on childEducation screen taps on letsGetStarted
    And user on childEducation screen taps on nextButton
    And user on childEducation screen taps on nextButton
    And user on childEducation screen taps on threeChildren
    And user on childEducation screen slides on child1Age value 40%
    And user on childEducation screen slides on child2Age value 80%
    And user on childEducation screen slides on child3Age value 60%
    And user on childEducation screen taps on nextButtonChildAge
    And user on childEducation screen taps on collegeOverseasForChildOne
    And user on childEducation screen taps on collegeOverseasForChildTwo
    And user on childEducation screen taps on collegeOverseasForChildThree
    And user on childEducation screen taps on nextButtonOverseas
    And user on childEducation screen taps on scienceSubjectForChildOne
    And user on childEducation screen taps on nextButtonChildAge
    And user on childEducation screen taps on artsSubjectForChildTwo
    And user on childEducation screen taps on nextButtonChildAge
    And user on childEducation screen taps on businessSubjectForChildThree
    And user on childEducation screen taps on nextButtonChildAge
    And user on ChildEducation screen taps on savingSwitch
    And user on childEducation screen slides on savingSlider value 60%
    And user on childEducation screen taps on nextButtonChildAge
    And user on childEducation screen taps on nextButtonChildAge
    And user on childEducation screen taps on nextButtonChildAge
    And user on childEducation screen taps on goToInvestButton

  @health
  Scenario: generic step example 4
    And user on planning screen taps on healthCard
    And user on health screen taps on letsGetStarted
    And user on health screen taps on age
    And user on health screen taps on city
    And user on health screen taps on savingPercentage
    And user on health screen taps on longTermInvestment
    And user on health screen taps on shortTermInvestment
    And user on health screen taps on insurance
    And user on health screen taps on savingTax
    And user on health screen taps on nextButton
    And user on health screen taps on nextButton

  @invest_money
  Scenario: generic step example 5
    And user on planning screen taps on investMoneyCard
    And user on investMoney screen taps on letsGetStarted
    And user on investMoney screen taps on investMoneyEveryMonth
    And user on investMoney screen slides on  investSlider value 70%
    And user on investMoney screen taps on years
    And user on investMoney screen slides on yearSlider value 0%
    And user on investMoney screen taps on nextButton
    And user on investMoney screen taps on nextButton
    And user on investMoney screen taps on nextButton
    And user on investMoney screen taps on next
    And user on investMoney screen taps on next
    And user on investMoney screen taps on showMeButton

    @exp
    Scenario: generic step example 6
#      Given user on home screen taps on menu
#      And user on menu screen scrolls down and taps on servicesAgreement

#    Given user on home screen swipes right to plan
#      And user on home screen swipes left to learn
#      And user on home screen scrolls down
#      And user on home screen scrolls down
#      And user on learn screen scrolls up and taps on articles

#      this is causing an error.





