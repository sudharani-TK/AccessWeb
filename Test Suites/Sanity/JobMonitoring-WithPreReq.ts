<?xml version="1.0" encoding="UTF-8"?>
<TestSuiteEntity>
   <description></description>
   <name>JobMonitoring-WithPreReq</name>
   <tag></tag>
   <isRerun>false</isRerun>
   <mailRecipient></mailRecipient>
   <numberOfRerun>0</numberOfRerun>
   <pageLoadTimeout>30</pageLoadTimeout>
   <pageLoadTimeoutDefault>true</pageLoadTimeoutDefault>
   <rerunFailedTestCasesOnly>false</rerunFailedTestCasesOnly>
   <rerunImmediately>false</rerunImmediately>
   <testSuiteGuid>e64c0152-92f0-4ea7-9afc-a3abb9bf7afc</testSuiteGuid>
   <testCaseLink>
      <guid>09316c6a-4551-4de4-894d-ce7fec709bad</guid>
      <isReuseDriver>false</isReuseDriver>
      <isRun>false</isRun>
      <testCaseId>Test Cases/JobMonitoring/Pre-Req-Script-For-JobMonitoring-Ops</testCaseId>
      <usingDataBindingAtTestSuiteLevel>true</usingDataBindingAtTestSuiteLevel>
      <variableLink>
         <testDataLinkId></testDataLinkId>
         <type>DEFAULT</type>
         <value></value>
         <variableId>07e6f513-a04f-4fe3-b70a-198f3f69be18</variableId>
      </variableLink>
      <variableLink>
         <testDataLinkId></testDataLinkId>
         <type>DEFAULT</type>
         <value></value>
         <variableId>64007784-bca4-488a-8a51-9d250067468a</variableId>
      </variableLink>
      <variableLink>
         <testDataLinkId></testDataLinkId>
         <type>DEFAULT</type>
         <value></value>
         <variableId>1c87bd78-81b1-402b-ae17-375332c5d79c</variableId>
      </variableLink>
      <variableLink>
         <testDataLinkId></testDataLinkId>
         <type>DEFAULT</type>
         <value></value>
         <variableId>9e1d0a01-35b1-4e4d-b5c8-bb176ad9c1bc</variableId>
      </variableLink>
      <variableLink>
         <testDataLinkId></testDataLinkId>
         <type>DEFAULT</type>
         <value></value>
         <variableId>8f94f9b9-3a18-4eca-b080-5ff2e6edd9b9</variableId>
      </variableLink>
      <variableLink>
         <testDataLinkId></testDataLinkId>
         <type>DEFAULT</type>
         <value></value>
         <variableId>b1c12b7f-deff-4bfd-b652-c2cc17ec0237</variableId>
      </variableLink>
      <variableLink>
         <testDataLinkId></testDataLinkId>
         <type>DEFAULT</type>
         <value></value>
         <variableId>d2c17f74-dfaa-42a1-9883-795f51ef28cf</variableId>
      </variableLink>
   </testCaseLink>
   <testCaseLink>
      <guid>2b6856f4-a9e7-4bc3-819c-a82e923b0b35</guid>
      <isReuseDriver>false</isReuseDriver>
      <isRun>false</isRun>
      <testCaseId>Test Cases/JobMonitoring/Pre-Req-Script-For-JobMonitoring-AllJobs</testCaseId>
      <usingDataBindingAtTestSuiteLevel>true</usingDataBindingAtTestSuiteLevel>
      <variableLink>
         <testDataLinkId></testDataLinkId>
         <type>DEFAULT</type>
         <value></value>
         <variableId>a4f1d6a7-dcfa-440e-a86e-3bb10a8dea6c</variableId>
      </variableLink>
      <variableLink>
         <testDataLinkId></testDataLinkId>
         <type>DEFAULT</type>
         <value></value>
         <variableId>996e8ea2-cec6-4c30-b0d1-7cd8c8b66f02</variableId>
      </variableLink>
      <variableLink>
         <testDataLinkId></testDataLinkId>
         <type>DEFAULT</type>
         <value></value>
         <variableId>58ab5183-dd64-4c89-9a2a-3ed385f18550</variableId>
      </variableLink>
      <variableLink>
         <testDataLinkId></testDataLinkId>
         <type>DEFAULT</type>
         <value></value>
         <variableId>d3635dc1-452f-48c6-af58-4f9702f180b3</variableId>
      </variableLink>
      <variableLink>
         <testDataLinkId></testDataLinkId>
         <type>DEFAULT</type>
         <value></value>
         <variableId>e32d5445-6f42-4d0f-a8ea-4b765f7310eb</variableId>
      </variableLink>
      <variableLink>
         <testDataLinkId></testDataLinkId>
         <type>DEFAULT</type>
         <value></value>
         <variableId>1f0aeaa5-6880-49cb-8d7a-14ac8e0f1c1e</variableId>
      </variableLink>
      <variableLink>
         <testDataLinkId></testDataLinkId>
         <type>DEFAULT</type>
         <value></value>
         <variableId>55b52fe6-5593-4c7d-8008-a30c51ac0f0b</variableId>
      </variableLink>
   </testCaseLink>
   <testCaseLink>
      <guid>a1555019-a296-44e4-a236-ad82f1782e18</guid>
      <isReuseDriver>false</isReuseDriver>
      <isRun>true</isRun>
      <testCaseId>Test Cases/JobMonitoring/JobActions_ForJobStates</testCaseId>
      <testDataLink>
         <combinationType>ONE</combinationType>
         <id>de3de7c4-8a67-4b96-9c3f-44b6f7372061</id>
         <iterationEntity>
            <iterationType>SPECIFIC</iterationType>
            <value>11, 15,1-10,12-14,16</value>
         </iterationEntity>
         <testDataId>Data Files/Sanity/JobAction</testDataId>
      </testDataLink>
      <usingDataBindingAtTestSuiteLevel>true</usingDataBindingAtTestSuiteLevel>
      <variableLink>
         <testDataLinkId>de3de7c4-8a67-4b96-9c3f-44b6f7372061</testDataLinkId>
         <type>DATA_COLUMN</type>
         <value>JobState</value>
         <variableId>fa14e12e-5a6a-419f-8a7f-e37415e0594a</variableId>
      </variableLink>
      <variableLink>
         <testDataLinkId>de3de7c4-8a67-4b96-9c3f-44b6f7372061</testDataLinkId>
         <type>DATA_COLUMN</type>
         <value>JobAction</value>
         <variableId>733a2509-5f57-4bf7-83e2-b170d379821f</variableId>
      </variableLink>
      <variableLink>
         <testDataLinkId>de3de7c4-8a67-4b96-9c3f-44b6f7372061</testDataLinkId>
         <type>DATA_COLUMN</type>
         <value>TestCaseName</value>
         <variableId>deeba42e-d802-4544-b79c-5f155f26e90d</variableId>
      </variableLink>
      <variableLink>
         <testDataLinkId></testDataLinkId>
         <type>DEFAULT</type>
         <value></value>
         <variableId>b9a88c01-3e4a-42b5-8a6d-68ece165320d</variableId>
      </variableLink>
      <variableLink>
         <testDataLinkId></testDataLinkId>
         <type>DEFAULT</type>
         <value></value>
         <variableId>6ce0cbfc-68da-4faa-ad9f-89b693d75962</variableId>
      </variableLink>
   </testCaseLink>
   <testCaseLink>
      <guid>46169b3c-0cd6-4158-a8ce-7add6dfb4583</guid>
      <isReuseDriver>false</isReuseDriver>
      <isRun>true</isRun>
      <testCaseId>Test Cases/JobMonitoring/Jobdetailspage_context menu</testCaseId>
      <testDataLink>
         <combinationType>ONE</combinationType>
         <id>c527aaac-1585-4a91-9518-435233c53e79</id>
         <iterationEntity>
            <iterationType>SPECIFIC</iterationType>
            <value>1-15</value>
         </iterationEntity>
         <testDataId>Data Files/Regression/TestDataForJobDetails</testDataId>
      </testDataLink>
      <usingDataBindingAtTestSuiteLevel>true</usingDataBindingAtTestSuiteLevel>
      <variableLink>
         <testDataLinkId>c527aaac-1585-4a91-9518-435233c53e79</testDataLinkId>
         <type>DATA_COLUMN</type>
         <value>JobState</value>
         <variableId>4a636c84-6f6f-4327-bc88-0f06ed57c48e</variableId>
      </variableLink>
      <variableLink>
         <testDataLinkId>c527aaac-1585-4a91-9518-435233c53e79</testDataLinkId>
         <type>DATA_COLUMN</type>
         <value>JobAction</value>
         <variableId>b07c6840-6124-403c-88c8-73fd685aac37</variableId>
      </variableLink>
      <variableLink>
         <testDataLinkId>c527aaac-1585-4a91-9518-435233c53e79</testDataLinkId>
         <type>DATA_COLUMN</type>
         <value>TestCaseName</value>
         <variableId>95be6fc3-cb4f-4e7e-aee7-4913d254fd84</variableId>
      </variableLink>
      <variableLink>
         <testDataLinkId>c527aaac-1585-4a91-9518-435233c53e79</testDataLinkId>
         <type>DATA_COLUMN</type>
         <value>userChoice</value>
         <variableId>aa175b05-32fc-49ca-a330-8cfe38b2837c</variableId>
      </variableLink>
      <variableLink>
         <testDataLinkId></testDataLinkId>
         <type>DEFAULT</type>
         <value></value>
         <variableId>356270a5-54ea-4c61-92e8-d4bb0389a9fa</variableId>
      </variableLink>
   </testCaseLink>
   <testCaseLink>
      <guid>4dd70b4d-dcc9-4870-8100-e136cd50770e</guid>
      <isReuseDriver>false</isReuseDriver>
      <isRun>true</isRun>
      <testCaseId>Test Cases/JobMonitoring/FileViewerOpsJobs</testCaseId>
      <testDataLink>
         <combinationType>ONE</combinationType>
         <id>50200266-97c2-41fd-93a5-24ef305f7f99</id>
         <iterationEntity>
            <iterationType>ALL</iterationType>
            <value></value>
         </iterationEntity>
         <testDataId>Data Files/Regression/TestDataFileViewerJobs</testDataId>
      </testDataLink>
      <usingDataBindingAtTestSuiteLevel>true</usingDataBindingAtTestSuiteLevel>
      <variableLink>
         <testDataLinkId></testDataLinkId>
         <type>DEFAULT</type>
         <value></value>
         <variableId>de80f296-8774-4025-ada0-c0a561551dfc</variableId>
      </variableLink>
      <variableLink>
         <testDataLinkId></testDataLinkId>
         <type>DEFAULT</type>
         <value></value>
         <variableId>1ef3044b-3e18-4358-b053-f5cc634b8c9c</variableId>
      </variableLink>
      <variableLink>
         <testDataLinkId></testDataLinkId>
         <type>DEFAULT</type>
         <value></value>
         <variableId>b7255d04-d5ff-4509-879f-742686a1bd73</variableId>
      </variableLink>
      <variableLink>
         <testDataLinkId></testDataLinkId>
         <type>DEFAULT</type>
         <value></value>
         <variableId>caf2b1c8-58a9-4a4b-b40e-683a4064bb84</variableId>
      </variableLink>
      <variableLink>
         <testDataLinkId></testDataLinkId>
         <type>DEFAULT</type>
         <value></value>
         <variableId>f478ca9c-2981-4783-8198-7e3aca99cf14</variableId>
      </variableLink>
      <variableLink>
         <testDataLinkId></testDataLinkId>
         <type>DEFAULT</type>
         <value></value>
         <variableId>61b6ede2-14cd-45af-bd30-74fa3058990f</variableId>
      </variableLink>
   </testCaseLink>
</TestSuiteEntity>
